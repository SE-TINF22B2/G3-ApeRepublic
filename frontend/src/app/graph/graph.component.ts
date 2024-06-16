import {
  AfterViewInit,
  Component,
  ElementRef,
  Input,
  NgModule,
  OnDestroy,
  OnInit,
  Renderer2,
  ViewChild
} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import {CanvasJS, CanvasJSAngularStockChartsModule} from '@canvasjs/angular-stockcharts';
import {interval, max, Subscription} from "rxjs";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";




@Component({
  selector: 'app-graph',
  standalone: true,
  imports: [RouterOutlet, CommonModule, CanvasJSAngularStockChartsModule, MatProgressSpinnerModule],
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss']
})

export class GraphComponent implements AfterViewInit, OnInit, OnDestroy {
  @Input() width!: string;
  @Input() datapoints!: [];
  @Input() chartId!: string;

  private formattedDatapoints: { x: Date; y: number }[] = [];
  private mySub: Subscription | undefined;
  private chart: { render: () => void; } | undefined;

  constructor(private el: ElementRef, private renderer: Renderer2) {
  }


  chartOptions = {
    theme: "dark2",
    animationEnabled: true,
    zoomEnabled: false,

    axisY: {
      labelFormatter: (e: any) => {
        return "$" + (e.value.toFixed(2));
      },
      gridThickness: 1,
      gridColor: "#7A848D"
    },
    axisX:{
      valueFormatString: "HH:mm:ss",
      labelAngle: -50
    },
    toolTip:{
      content: "{x}: ${y}"
    },
    data: [{
      type: "line",
      color: 'red',
      xValueFormatString: "HH:mm:ss",

      dataPoints: this.formattedDatapoints
    }]
  }

  chartLoaded() {
    return this.formattedDatapoints.length != 0;
  }

  reduce(data: { x: Date, y: number }[]) {
    const maxPoints = 1000;
    const length = data.length;

    if (length <= maxPoints) {
      return;
    }

    const interval = Math.ceil(length / (length - maxPoints));
    const reducedData: { x: Date, y: number }[] = [];

    console.log("------");
    console.log("MaxPoints: " + maxPoints);
    console.log("Length: " + length);
    console.log("Übertrag: " + (length - maxPoints));
    console.log("Interval: " + interval);

    let counter = 0;
    for (let i = 0; i < length; i++) {
      if (i % interval == 0) {
        counter++;
        const chunk = data.slice(i, i + 2);
        const avgX = new Date(chunk.reduce((sum, item) => sum + item.x.getTime(), 0) / chunk.length);
        const avgY = chunk.reduce((sum, item) => sum + item.y, 0) / chunk.length;
        reducedData.push({ x: avgX, y: avgY });
        i++;
      } else {
        reducedData.push(data.at(i)!);
      }
    }

    this.formattedDatapoints = reducedData;
    console.log("counter: " + counter);
    console.log("ResultLength: " + this.formattedDatapoints.length);
    console.log("------");

    if (this.formattedDatapoints.length > maxPoints) {
      this.reduce(this.formattedDatapoints);
    }
  }

  ngOnInit(): void {
    this.mySub = interval(2000).subscribe((func => {
      for (const datapoint of this.datapoints) {
        // @ts-ignore
        this.formattedDatapoints.push({x: new Date(parseInt(datapoint.timestamp)), y: parseFloat(datapoint.price.toFixed(2))
        })
      }
      // @ts-ignore
      this.formattedDatapoints.sort((a, b) => a.x.getTime() - b.x.getTime());

      //this.reduce(this.formattedDatapoints);

      this.chart?.render();

      const elements = this.el.nativeElement.getElementsByClassName('canvasjs-chart-credit');
      for (let i = 0; i < elements.length; i++) {
        this.renderer.removeChild(this.el.nativeElement, elements[i]);
      }
    }));
  }

  ngAfterViewInit(): void {
    this.chart = new CanvasJS.Chart(this.chartId, this.chartOptions);
    const elements = this.el.nativeElement.getElementsByClassName('canvasjs-chart-credit');
    for (let i = 0; i < elements.length; i++) {
      this.renderer.removeChild(this.el.nativeElement, elements[i]);
    }
  }

  ngOnDestroy(): void {
    this.mySub?.unsubscribe();
  }
}
