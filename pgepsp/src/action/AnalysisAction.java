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
	// ����ע���
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

	// ��chart
	private JFreeChart chart = null;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	// ��ҳ���Ĵ�ֵ
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

	// ͳ����ҳ
	public String showChart() {
		return "show";
	}

	// ��ɾ�鷽��
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

	// �������߸�ʮƪ���µ�ֱ��ͼ
	@SuppressWarnings({ "rawtypes"})
	public String topLookingCountChart() {
		// ��ȡ����
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
			if (type.equals("�ڿ�����")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("��Ҫ�����Ҫ")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("�Ļ����Ҫ")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("��������")){
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
		// ��ʼ��ͼ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int k = 0; k <= 9; k++) {
			dataset.setValue(Integer.parseInt(countList[k]), "", idList[k]);
		}
		chart = ChartFactory.createBarChart("��������top10", "����ID", "�����",
				dataset, PlotOrientation.VERTICAL, false, true, false);
		// ����ͼ���ñ���
		chart.setTitle(new TextTitle("��������top10", new Font("��Բ", Font.BOLD, 22)));
		chart.setBackgroundPaint(new Color(200, 255, 100));
		// �м䲿��
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// ����ˮƽ�������ʽ
		plot.setBackgroundPaint(Color.darkGray);
		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
		// ������ֱ�������ʽ
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// chart.getLegend();
		return "barchart";
	}

	// //�������߸�ʮƪ���µ�������ʾҳ
	@SuppressWarnings({ "rawtypes" })
	public String topLookingCountView() {
		// ��ȡ����
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
			if (type.equals("�ڿ�����")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("��Ҫ�����Ҫ")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("�Ļ����Ҫ")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("��������")){
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

	// ͣ��ʱ�����ʮƪ���µ�ֱ��ͼ
	@SuppressWarnings({ "rawtypes" })
	public String topLookingTimeChart() {
		// ��ȡ����
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
			if (type.equals("�ڿ�����")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("��Ҫ�����Ҫ")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("�Ļ����Ҫ")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("��������")){
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
		// ��ʼ��ͼ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int k = 0; k <= 9; k++) {
			dataset.setValue(Long.parseLong(countList[k]), "", idList[k]);
		}
		chart = ChartFactory
				.createBarChart3D("���ʱ�������top10", "����ID", "ʱ��(��)", dataset,
						PlotOrientation.VERTICAL, false, true, false);
		// ����ͼ���ñ���
		chart.setTitle(new TextTitle("���ʱ�������top10", new Font("��Բ", Font.BOLD,
				22)));
		chart.setBackgroundPaint(new Color(255, 255, 255));
		// �м䲿��
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// ����ˮƽ�������ʽ
		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
		// ������ֱ�������ʽ
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// chart.getLegend();
		return "barchart";
	}

	// ͣ��ʱ�����ʮƪ���µ���ʾҳ
	@SuppressWarnings({ "rawtypes" })
	public String topLookingTimeView() {
		// ��ȡ����
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
			if (type.equals("�ڿ�����")) {
				title[j] = pubSer.findPr(Integer.parseInt(idList[j]))
						.getP_title();
				j++;
			}
			if (type.equals("��Ҫ�����Ҫ")) {
				title[j] = hyjSer.findFromId(Integer.parseInt(idList[j]))
						.getM_title();
				j++;
			}
			if (type.equals("�Ļ����Ҫ")) {
				title[j] = hdjSer.findFromId(Integer.parseInt(idList[j]))
						.getA_title();
				j++;
			}
			if(type.equals("��������")){
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

	// ��ͬʱ��ε�����ͼ
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
		// ��ʼ��ͼ
		TimeSeries s1 = new TimeSeries("ʱ���������������", Hour.class);
		for (int j = 0; j < 23; j++) {
			s1.add(new Hour(j, 22, 8, 2013), countList[j]);
		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		chart = ChartFactory.createTimeSeriesChart("��ͬʱ�����������ͼ", "ʱ��", "",
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

	// ��ͬʱ��ε�������ʾҳ
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
	 * DefaultCategoryDataset(); dataset.setValue(100, "����", "����");
	 * dataset.setValue(100, "�Ϻ�", "����"); dataset.setValue(10, "����", "����");
	 * dataset.setValue(10, "�Ϻ�", "����"); dataset.setValue(30, "����", "����");
	 * dataset.setValue(30, "�Ϻ�", "����"); dataset.setValue(8, "����", "������");
	 * dataset.setValue(8, "�Ϻ�", "������"); chart =
	 * ChartFactory.createBarChart3D("��Ȥͳ�ƽ��", "��Ŀ", "����", dataset
	 * ,PlotOrientation.VERTICAL, false,true, false); //����ͼ���ñ���
	 * chart.setTitle(new TextTitle("��Ȥͳ�ƽ��", new Font("����", Font.BOLD, 22)));
	 * //�м䲿�� CategoryPlot plot = (CategoryPlot) chart.getPlot(); //����ˮƽ�������ʽ
	 * CategoryAxis categoryAxis = plot.getDomainAxis();
	 * categoryAxis.setLabelFont(new Font("����", Font.BOLD,10));
	 * categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
	 * //������ֱ�������ʽ NumberAxis numberAxis=(NumberAxis)plot.getRangeAxis();
	 * numberAxis.setLabelFont(new Font("�� ��",Font.LAYOUT_NO_LIMIT_CONTEXT,
	 * 10)); //chart.getLegend(); return "chart"; }
	 */

}
