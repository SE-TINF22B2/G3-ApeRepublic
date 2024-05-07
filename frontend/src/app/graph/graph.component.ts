import { Component, NgModule } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CanvasJSAngularStockChartsModule } from '@canvasjs/angular-stockcharts';



@Component({
  selector: 'app-graph',
  standalone: true,
  imports: [RouterOutlet, CommonModule, CanvasJSAngularStockChartsModule],
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss']
})

export class GraphComponent {
  generateRandomData = () => {
    var y = 1000, dps = [];
    for (var i = 0; i < 1000; i++) {
        y += Math.round(5 + Math.random() * (-5 - 5));
        dps.push({ y: y });
    }
    return dps;
}
stockChartOptions = {
    exportEnabled: true,
    title: {
        text: " "
    },
    charts: [{
        data: [{
            type: "line",
            dataPoints: this.generateRandomData()
        }]
    }],
    rangeSelector: {
        inputFields: {
            startValue: 200,
            endValue: 800
        },
        buttons: [{
            label: "1m",
            range: 100,
            rangeType: "number"
        }, {
            label: "6m",
            range: 200,
            rangeType: "number"
        }, {
            label: "1y",
            range: 500,
            rangeType: "number"
        }, {
            label: "All",
            rangeType: "all"
        }]
    }
}
}       