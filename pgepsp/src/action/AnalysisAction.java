package action;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import model.IndexLooking;
import model.Statistics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import service.HbsyService;
import service.HdjyService;
import service.HyjyService;
import service.IndexService;
import service.PublishService;
import service.StatisticsService;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class AnalysisAction extends ActionSupport {
	private static final long serialVersionUID = -7734268498295158727L;
	// 依赖注入块
	public PublishService pubSer;
	public StatisticsService staSer;
	public IndexService indSer;
	public HbsyService hbsSer;
	public HdjyService hdjSer;
	public HyjyService hyjSer;
	public void setHbsSer(HbsyService hbsSer) {
		this.hbsSer = hbsSer;
	}

	public void setHdjSer(HdjyService hdjSer) {
		this.hdjSer = hdjSer;
	}

	public void setHyjSer(HyjyService hyjSer) {
		this.hyjSer = hyjSer;
	}
	public void setIndSer(IndexService indSer) {
		this.indSer = indSer;
	}

	public void setStaSer(StatisticsService staSer) {
		this.staSer = staSer;
	}

	public void setPubSer(PublishService pubSer) {
		this.pubSer = pubSer;
	}

	// 传chart
	private JFreeChart chart = null;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	// 与页面间的传值
	protected Long[] countList;

	public Long[] getCountList() {
		return countList;
	}

	public void setCountList(Long[] countList) {
		this.countList = countList;
	}

	protected String[][] data = new String[4][10];

	public String[][] getData() {
		return data;
	}

	public void setData(String[][] data) {
		this.data = data;
	}

	protected IndexLooking indLoo;
	protected Statistics sta;
	protected String enterTime;
	protected String closeTime;
	protected String totalTime;
	public IndexLooking getIndLoo() {
		return indLoo;
	}

	public void setIndLoo(IndexLooking indLoo) {
		this.indLoo = indLoo;
	}
	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public Statistics getSta() {
		return sta;
	}

	public void setSta(Statistics sta) {
		this.sta = sta;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	// 统计首页
	public String showChart() {
		return "show";
	}

	// 增删查方法
	public void addSta() throws ParseException {
		Date e = new Date();
		e.setTime(Long.valueOf(enterTime));
		Date c = new Date();
		c.setTime(Long.valueOf(closeTime));
		sta.setS_enterTime(e);
		sta.setS_closeTime(c);
		sta.setS_totalTime(Long.parseLong(totalTime));
		staSer.saveSta(sta);
	}

	public void addInd(){
		indLoo=new IndexLooking();
		Date e = new Date();
		e.setTime(Long.valueOf(enterTime));
		indLoo.setI_enterTime(e);
		indSer.saveIndLoo(indLoo);
	}

	// 点击率最高高十篇文章的直方图
	@SuppressWarnings({ "rawtypes"})
	public String topLookingCountChart() {
		// 获取数据
		List a = staSer
				.find("select FK_id,count(*) as num,s_type from Statistics"
						+ " group by FK_id,s_type order by num Desc");
		String[] idList = new String[10];
		String[] countList = new String[10];
		String[] typeList = new String[10];
		String[] title = new String[10];
		Iterator itr = a.iterator();
		int i = 0;
		while (itr.hasNext()) {
			Object[] item = (Object[]) itr.next();
			idList[i] = item[0].toString();
			countList[i] = item[1].toString();
			typeList[i] = item[2].toString();
			if (i == 9) {
				break;
			}
			i++;
		}
		if(idList[0]!=null&&idList[1]!=null&&idList[2]!=null&&idList[3]!=null&&idList[4]!=null&&idList[5]!=null
				&&idList[6]!=null&&idList[7]!=null&&idList[8]!=null&&idList[9]!=null){
		int j = 0;
		for (String type : typeList) {
			if (type.equals("期刊导读")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("重要会议纪要")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("文化活动纪要")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("环保术语")){
				title[j] = hbsSer.findFromId(Integer.parseInt(idList[j]))
						.getE_name();
				j++;
			}
		}
		}
		else{
			idList = new String[10];
			countList = new String[10];
			typeList = new String[10];
			title = new String[10];
		}
		// 开始画图
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int k = 0; k <= 9; k++) {
			dataset.setValue(Integer.parseInt(countList[k]), "", idList[k]);
		}
		chart = ChartFactory.createBarChart("热门文章top10", "文章ID", "浏览量",
				dataset, PlotOrientation.VERTICAL, false, true, false);
		// 柱形图设置标题
		chart.setTitle(new TextTitle("热门文章top10", new Font("幼圆", Font.BOLD, 22)));
		chart.setBackgroundPaint(new Color(200, 255, 100));
		// 中间部分
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 设置水平方向的样式
		plot.setBackgroundPaint(Color.darkGray);
		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setLabelFont(new Font("楷体", Font.BOLD, 14));
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
		// 设置竖直方向的样式
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setLabelFont(new Font("楷体", Font.BOLD, 14));
		// chart.getLegend();
		return "barchart";
	}

	// //点击率最高高十篇文章的数据显示页
	@SuppressWarnings({ "rawtypes" })
	public String topLookingCountView() {
		// 获取数据
		List a = staSer
				.find("select FK_id,count(*) as num,s_type from Statistics"
						+ " group by FK_id,s_type order by num Desc");
		String[] idList = new String[10];
		String[] countList = new String[10];
		String[] typeList = new String[10];
		String[] title = new String[10];
		Iterator itr = a.iterator();
		int i = 0;
		while (itr.hasNext()) {
			Object[] item = (Object[]) itr.next();
			idList[i] = item[0].toString();
			countList[i] = item[1].toString();
			typeList[i] = item[2].toString();
			if (i == 9) {
				break;
			}
			i++;
		}
	if(idList[0]!=null&&idList[1]!=null&&idList[2]!=null&&idList[3]!=null&&idList[4]!=null&&idList[5]!=null
			&&idList[6]!=null&&idList[7]!=null&&idList[8]!=null&&idList[9]!=null){
		int j = 0;
		for (String type : typeList) {
			if (type.equals("期刊导读")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("重要会议纪要")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("文化活动纪要")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("环保术语")){
				title[j] = hbsSer.findFromId(Integer.parseInt(idList[j]))
						.getE_name();
				j++;
			}
		}
		data[0] = idList;
		data[1] = countList;
		data[2] = typeList;
		data[3] = title;
		return "toplookingcountview";
	}
	else{
			data[0] = new String[10];
			data[1] = new String[10];
			data[2] = new String[10];
			data[3] = new String[10];
			return "toplookingcountview";
		}
	}

	// 停留时间最长的十篇文章的直方图
	@SuppressWarnings({ "rawtypes" })
	public String topLookingTimeChart() {
		// 获取数据
		List a = staSer
				.find("select FK_id,sum(s_totalTime) as num,s_type from Statistics"
						+ " group by FK_id,s_type order by num Desc");
		String[] idList = new String[10];
		String[] countList = new String[10];
		String[] typeList = new String[10];
		String[] title = new String[10];
		Iterator itr = a.iterator();
		int i = 0;
		while (itr.hasNext()) {
			Object[] item = (Object[]) itr.next();
			idList[i] = item[0].toString();
			countList[i] = item[1].toString();
			typeList[i] = item[2].toString();
			if (i == 9) {
				break;
			}
			i++;
		}
		if(idList[0]!=null&&idList[1]!=null&&idList[2]!=null&&idList[3]!=null&&idList[4]!=null&&idList[5]!=null
				&&idList[6]!=null&&idList[7]!=null&&idList[8]!=null&&idList[9]!=null){
		int j = 0;
		for (String type : typeList) {
			if (type.equals("期刊导读")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("重要会议纪要")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("文化活动纪要")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("环保术语")){
				title[j] = hbsSer.findFromId(Integer.parseInt(idList[j]))
						.getE_name();
				j++;
			}
		}
		}
		else{
			idList = new String[10];
			countList = new String[10];
			typeList = new String[10];
			title = new String[10];
		}
		for(int l=0;l<=9;l++){
			countList[l]=((Long)((Long.parseLong(countList[l]))/1000)).toString();
		}
		// 开始画图
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int k = 0; k <= 9; k++) {
			dataset.setValue(Long.parseLong(countList[k]), "", idList[k]);
		}
		chart = ChartFactory
				.createBarChart3D("浏览时间最长文章top10", "文章ID", "时长(秒)", dataset,
						PlotOrientation.VERTICAL, false, true, false);
		// 柱形图设置标题
		chart.setTitle(new TextTitle("浏览时间最长文章top10", new Font("幼圆", Font.BOLD,
				22)));
		chart.setBackgroundPaint(new Color(255, 255, 255));
		// 中间部分
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 设置水平方向的样式
		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setLabelFont(new Font("楷体", Font.BOLD, 14));
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
		// 设置竖直方向的样式
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setLabelFont(new Font("楷体", Font.BOLD, 14));
		// chart.getLegend();
		return "barchart";
	}

	// 停留时间最长的十篇文章的显示页
	@SuppressWarnings({ "rawtypes" })
	public String topLookingTimeView() {
		// 获取数据
		List a = staSer
				.find("select FK_id,sum(s_totalTime) as num,s_type from Statistics"
						+ " group by FK_id,s_type order by num Desc");
		String[] idList = new String[10];
		String[] countList = new String[10];
		String[] typeList = new String[10];
		String[] title = new String[10];
		Iterator itr = a.iterator();
		int i = 0;
		while (itr.hasNext()) {
			Object[] item = (Object[]) itr.next();
			idList[i] = item[0].toString();
			countList[i] = item[1].toString();
			typeList[i] = item[2].toString();
			if (i == 9) {
				break;
			}
			i++;
		}
		if(idList[0]!=null&&idList[1]!=null&&idList[2]!=null&&idList[3]!=null&&idList[4]!=null&&idList[5]!=null
				&&idList[6]!=null&&idList[7]!=null&&idList[8]!=null&&idList[9]!=null){
		int j = 0;
		for (String type : typeList) {
			if (type.equals("期刊导读")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("重要会议纪要")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("文化活动纪要")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("环保术语")){
				title[j] = hbsSer.findFromId(Integer.parseInt(idList[j]))
						.getE_name();
				j++;
			}
		}
		for(int l=0;l<=9;l++){
			countList[l]=((Long)((Long.parseLong(countList[l]))/1000)).toString();
		}
		data[0] = idList;
		data[1] = countList;
		data[2] = typeList;
		data[3] = title;
		return "toplookingtimeview";
		}
		else{
			data[0] = new String[10];
			data[1] = new String[10];
			data[2] = new String[10];
			data[3] = new String[10];
		return "toplookingtimeview";
		}
	}

	// 不同时间段的折线图
	public String todayLooking() {
		countList = new Long[24];
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String time = formatter.format(today);
		String[] hqlList = new String[24];
		for (int m = 0; m < 24; m++) {
			if (m < 9) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " 0"
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time
						+ " 0"
						+ (m + 1)
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')";
			}
			if (m == 9) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " 0"
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time
						+ " "
						+ (m + 1)
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')";
			}
			if (m > 9 && m < 23) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " "
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time
						+ " "
						+ (m + 1)
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')";
			}
			if (m == 23) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " "
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time + " " + m + ":59:59','yyyy/MM/dd HH24:MI:SS')";
			}
		}
		@SuppressWarnings("rawtypes")
		List a;
		for (int k = 0; k < 24; k++) {
			if (indSer.find(hqlList[k]) != null) {
				a = indSer.find(hqlList[k]);
				countList[k] = (Long) a.get(0);
			} else {
				countList[k] = (long) 0;
			}
			;
		}
		// 开始画图
		TimeSeries s1 = new TimeSeries("时间与浏览量的曲线", Hour.class);
		for (int j = 0; j < 23; j++) {
			s1.add(new Hour(j, 22, 8, 2013), countList[j]);
		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		chart = ChartFactory.createTimeSeriesChart("不同时段浏览量折线图", "时刻", "",
				dataset, false, true, false);
		chart.setBackgroundPaint(new Color(0, 120, 170));
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.blue);
		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer renderer = plot.getRenderer();
		if (renderer instanceof StandardXYItemRenderer) {
			StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
			rr.setPlotLines(true);
		}
		// DateAxis axis = (DateAxis) plot.getDomainAxis();
		// axis.setDateFormatOverride(new SimpleDateFormat("MM-yyyy"));
		return "linechart";
	}

	// 不同时间段的数据显示页
	public String todayLookingView() {
		countList = new Long[24];
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String time = formatter.format(today);
		String[] hqlList = new String[24];
		for (int m = 0; m < 24; m++) {
			if (m < 9) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " 0"
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time
						+ " 0"
						+ (m + 1)
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')";
			}
			if (m == 9) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " 0"
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time
						+ " "
						+ (m + 1)
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')";
			}
			if (m > 9 && m < 23) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " "
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time
						+ " "
						+ (m + 1)
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')";
			}
			if (m == 23) {
				hqlList[m] = "select count(*) as num from IndexLooking where i_enterTime between "
						+ "to_date('"
						+ time
						+ " "
						+ m
						+ ":00:00','yyyy/MM/dd HH24:MI:SS')"
						+ " and to_date('"
						+ time + " " + m + ":59:59','yyyy/MM/dd HH24:MI:SS')";
			}
		}
		@SuppressWarnings("rawtypes")
		List a;
		for (int k = 0; k < 24; k++) {
			if (indSer.find(hqlList[k]) != null) {
				a = indSer.find(hqlList[k]);
				countList[k] = (Long) a.get(0);
			} else {
				countList[k] = (long) 0;
			}
			;
		}
		return "todaylookingview";
	}

	/*
	 * public String analysisChart(){ DefaultCategoryDataset dataset = new
	 * DefaultCategoryDataset(); dataset.setValue(100, "湖北", "篮球");
	 * dataset.setValue(100, "上海", "篮球"); dataset.setValue(10, "湖北", "足球");
	 * dataset.setValue(10, "上海", "足球"); dataset.setValue(30, "湖北", "排球");
	 * dataset.setValue(30, "上海", "排球"); dataset.setValue(8, "湖北", "保龄球");
	 * dataset.setValue(8, "上海", "保龄球"); chart =
	 * ChartFactory.createBarChart3D("兴趣统计结果", "项目", "人数", dataset
	 * ,PlotOrientation.VERTICAL, false,true, false); //柱形图设置标题
	 * chart.setTitle(new TextTitle("兴趣统计结果", new Font("黑体", Font.BOLD, 22)));
	 * //中间部分 CategoryPlot plot = (CategoryPlot) chart.getPlot(); //设置水平方向的样式
	 * CategoryAxis categoryAxis = plot.getDomainAxis();
	 * categoryAxis.setLabelFont(new Font("宋体", Font.BOLD,10));
	 * categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
	 * //设置竖直方向的样式 NumberAxis numberAxis=(NumberAxis)plot.getRangeAxis();
	 * numberAxis.setLabelFont(new Font("仿 宋",Font.LAYOUT_NO_LIMIT_CONTEXT,
	 * 10)); //chart.getLegend(); return "chart"; }
	 */

}
