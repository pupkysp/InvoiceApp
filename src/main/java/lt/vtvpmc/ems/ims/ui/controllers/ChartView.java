package lt.vtvpmc.ems.ims.ui.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import lt.vtvpmc.ems.ims.entities.Item;

@Controller
@Scope("session")
public class ChartView implements Serializable {

	private static final long serialVersionUID = 1400905527722295437L;

	private BarChartModel barModel;
	private List<Item> itemList;

	//postConstruct???
	public void init() {
		createBarModel();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries items = new ChartSeries();
		Map<Object, Number> map = new HashMap<>();
		for (Item i : itemList) {
			map.put(i.getAmount(), i.getPrice());
			items.setData(map);
		}
		model.addSeries(items);
		return model;
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
		yAxis.setMax(1000);
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
