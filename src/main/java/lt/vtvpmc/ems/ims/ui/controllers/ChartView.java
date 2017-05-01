package lt.vtvpmc.ems.ims.ui.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class ChartView implements Serializable{

	private static final long serialVersionUID = 1400905527722295437L;
	
	private BarChartModel barModel;
	
	@PostConstruct
	public void init(){
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries items = new ChartSeries();
        items.setLabel("Item");
        items.set("2004", 120);
        items.set("2005", 100);
        items.set("2006", 44);
        items.set("2007", 150);
        items.set("2008", 25);
 
        model.addSeries(items);
         
        return model;
    }
	
	private void createBarModels() {
        createBarModel();
    }
	
	private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Price by value");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Number of items in terms of value");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Price");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
}
