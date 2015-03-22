package com.baiyi.parttimejobs.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.util.Province;
//假如用到位置提醒功能，需要import该类
//如果使用地理围栏功能，需要import如下类

/*
 * 快速发布兼职
 */
public class QuickPublishJobs extends BaseActivity {
	private LocationClient mLocationClient = null;
	private BDLocationListener myListener = new MyLocationListener();
	private Spinner jobTypeSpinner, salaryTypeSpinner;
	private Button historyBtn;
	private Spinner provinceSpinner;// 省
	private Spinner citySpinner;// 市
	private Spinner countySpinner;// 区,县
	private String[][][] data;// 省市区县数据

	private EditText addrEditText;// 详细地址

	private int positionPorvince = 0;// 省得位置
	private int cityPorvince = 0;// 市的位置
	public String addr;// 当前地址

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_publish_jobs);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		initView();
		initLoc();
		// 从服务器读取
		/*
		 * String[] subItem = { "历史记录模板", "发单", "礼仪", "肯地基" };
		 * ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		 * getApplicationContext(), R.layout.my_simple_dropdown_item_1,
		 * subItem); adapter.setDropDownViewResource(android.R.layout.
		 * simple_spinner_dropdown_item); spinner.setAdapter(adapter);
		 */
		// 从数组读取
		String[] objects = { "销售", "安保", "礼仪", "促销", "翻译", "客服", "演出", "家教",
				"模特", "派单", "文员", "其他" };
		ArrayAdapter<String> jobTypeAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				objects);
		jobTypeAdapter
				.setDropDownViewResource(R.layout.my_simple_dropdown_item_1);
		jobTypeSpinner.setAdapter(jobTypeAdapter);
		// 工资结算方式
		String[] salaryType = { "小时/元", "天/元", "月/元" };
		ArrayAdapter<String> salaryAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				salaryType);
		salaryTypeSpinner.setAdapter(salaryAdapter);

		/*
		 * 省，市，区、县级联菜单
		 */
		// 获取省，直辖市
		String[] objects0 = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			objects0[i] = data[i][0][0];
		}
		// 默认显示北京
		ArrayAdapter<String> province = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				objects0);

		provinceSpinner.setAdapter(province);

		ArrayAdapter<String> city = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				new String[] { "北京市" });
		citySpinner.setAdapter(city);

		ArrayAdapter<String> countrySideAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				new String[] { "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区",
						"石景山区", "房山区", "通州区", "顺义区", "门头沟区", "昌平区", "大兴区",
						"怀柔区", "平谷区", "其它" });
		countySpinner.setAdapter(countrySideAdapter);

		provinceSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				ArrayAdapter<String> cityAdapter = null;

				ArrayList<String> city = new ArrayList<String>();// 获取省下面的市

				for (int j = 0; j < data[position].length; j++) {
					city.add(data[position][j][0]);

				}
				/*
				 * if(city.size()>0) city.remove(0);// 去掉第一个省名
				 */cityAdapter = new ArrayAdapter<String>(
						getApplicationContext(),
						R.layout.my_simple_dropdown_item_1, city);
				citySpinner.setAdapter(cityAdapter);
				positionPorvince = position;// 记录省在数组中的位置

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		// 根据市加载县
		citySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				ArrayAdapter<String> countyAdapter = null;
				cityPorvince = position;
				ArrayList<String> county = new ArrayList<String>();// 获取市下面的县
				for (int j2 = 0; j2 < data[positionPorvince][cityPorvince].length; j2++) {

					county.add(data[positionPorvince][cityPorvince][j2]);
				}
				/*
				 * if(county.size()>0) county.remove(0);//删除第一个省
				 */countyAdapter = new ArrayAdapter<String>(
						getApplicationContext(),
						R.layout.my_simple_dropdown_item_1, county);
				countySpinner.setAdapter(countyAdapter);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void initLoc() {
		mLocationClient = new LocationClient(getApplicationContext()); // 声明LocationClient类
		mLocationClient.registerLocationListener(myListener); // 注册监听函数

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
		option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
		option.setNeedDeviceDirect(true);// 返回的定位结果包含手机机头的方向

		mLocationClient.setLocOption(option);

	}

	private void initView() {
		historyBtn = (Button) findViewById(R.id.quick_publish_jobs_history);
		jobTypeSpinner = (Spinner) findViewById(R.id.quick_publish_job_type);
		salaryTypeSpinner = (Spinner) findViewById(R.id.quick_publish_job_salary_type);
		provinceSpinner = (Spinner) findViewById(R.id.quick_publish_jobs_province);
		citySpinner = (Spinner) findViewById(R.id.quick_publish_jobs_city);
		countySpinner = (Spinner) findViewById(R.id.quick_publish_jobs_countryside);

		addrEditText = (EditText) findViewById(R.id.quick_publish_jobs_addr);
		data = Province.data();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in Action Bar clicked; go home
			Intent intent = new Intent(this, HomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	// 省市县菜单适配器
	private class MySpinnerOnItemSelectedListener implements
			OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			/*
			 * for (int i = 0; i < data.length; i++) {
			 * 
			 * for (int j = 0; j < data[i].length; j++) {
			 * 
			 * for (int j2 = 0; j2 < data[i][j].length; j2++) {
			 * System.out.println(data[i][j][j2]); } } }
			 */
			ArrayAdapter<String> city = new ArrayAdapter<String>(
					getApplicationContext(),
					android.R.layout.simple_spinner_item, new String[] { "无" });
			citySpinner.setAdapter(city);

		}

	}

	//
	public void onPopupButtonClick(View button) {
		PopupMenu popup = new PopupMenu(this, button);
		popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(getApplicationContext(),
						"Clicked popup menu item " + item.getTitle(),
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});

		popup.show();
	}

	/*
	 * 地理位置获取
	 */
	public void onImageViewClick(View view) {
		mLocationClient.start();
		addrEditText.setText(addr);
		mLocationClient.stop();
	}

	/*
	 * 日历选择
	 */
	public void onCalendarListener(View view){
		
	}
	// 折叠列表适配器，暂时未用。
	private class MyExpandableListAdapter extends BaseExpandableListAdapter {
		// Sample data set. children[i] contains the children (String[]) for
		// groups[i].
		private String[] groups = { "历史兼职模板" };
		private String[][] children = { { "发单", "礼仪", "家教", "保姆" } };

		public Object getChild(int groupPosition, int childPosition) {
			return children[groupPosition][childPosition];
		}

		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		public int getChildrenCount(int groupPosition) {
			return children[groupPosition].length;
		}

		public TextView getGenericView() {
			// Layout parameters for the ExpandableListView
			AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 64);

			TextView textView = new TextView(getApplicationContext());
			textView.setLayoutParams(lp);
			// Center the text vertically
			textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			// Set the text starting position
			textView.setPadding(40, 0, 0, 0);

			return textView;
		}

		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			TextView textView = getGenericView();
			textView.setText(getChild(groupPosition, childPosition).toString());
			textView.setTextColor(getResources().getColor(R.color.child));
			return textView;
		}

		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		public int getGroupCount() {
			return groups.length;
		}

		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			TextView textView = getGenericView();
			textView.setText(getGroup(groupPosition).toString());
			textView.setTextColor(getResources().getColor(R.color.parent));
			return textView;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

		public boolean hasStableIds() {
			return true;
		}

	}

	private class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;

			if (location.getLocType() == BDLocation.TypeGpsLocation) {

			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

				addr = location.getAddrStr();
			}

		}
	}

}
