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
    chart: any;
    

	chartOptions = {
		
		animationEnabled: true,
		zoomEnabled: true,
		title: {
			text: "Apple"
		},
		axisY: {
			labelFormatter: (e: any) => {
				
				return "$" + (e.value );
			}
		},
		data: [{
			type: "line",
            color:'red',
            
			xValueFormatString: "YYYY",
			yValueFormatString: "$#,###.##",
			dataPoints: [
			  { x: new Date(2017, 6, 1), y: 5000 },
			  { x: new Date(2018, 1, 1), y: 4435},
              { x: new Date(2018, 6, 1), y: 4585},
			  { x: new Date(2019, 1, 1), y: 3652},
              { x: new Date(2019, 6, 1), y: 4365},
			  { x: new Date(2020, 1, 1), y: 1365},
              { x: new Date(2020, 6, 1), y: 1365},
			  { x: new Date(2021, 1, 1), y: 4505},
              { x: new Date(2021, 6, 1), y: 3526},
			  { x: new Date(2022, 1, 1), y: 3500},
              { x: new Date(2022, 6, 1), y: 1365},
              { x: new Date(2023, 1, 1), y: 3365},
			  { x: new Date(2023, 6, 1), y: 5235},
              { x: new Date(2024, 1, 1), y: 8802},
		
			 
			]
		}]
	}
}                        