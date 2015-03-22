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
//�����õ�λ�����ѹ��ܣ���Ҫimport����
//���ʹ�õ���Χ�����ܣ���Ҫimport������

/*
 * ���ٷ�����ְ
 */
public class QuickPublishJobs extends BaseActivity {
	private LocationClient mLocationClient = null;
	private BDLocationListener myListener = new MyLocationListener();
	private Spinner jobTypeSpinner, salaryTypeSpinner;
	private Button historyBtn;
	private Spinner provinceSpinner;// ʡ
	private Spinner citySpinner;// ��
	private Spinner countySpinner;// ��,��
	private String[][][] data;// ʡ����������

	private EditText addrEditText;// ��ϸ��ַ

	private int positionPorvince = 0;// ʡ��λ��
	private int cityPorvince = 0;// �е�λ��
	public String addr;// ��ǰ��ַ

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_publish_jobs);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		initView();
		initLoc();
		// �ӷ�������ȡ
		/*
		 * String[] subItem = { "��ʷ��¼ģ��", "����", "����", "�ϵػ�" };
		 * ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		 * getApplicationContext(), R.layout.my_simple_dropdown_item_1,
		 * subItem); adapter.setDropDownViewResource(android.R.layout.
		 * simple_spinner_dropdown_item); spinner.setAdapter(adapter);
		 */
		// �������ȡ
		String[] objects = { "����", "����", "����", "����", "����", "�ͷ�", "�ݳ�", "�ҽ�",
				"ģ��", "�ɵ�", "��Ա", "����" };
		ArrayAdapter<String> jobTypeAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				objects);
		jobTypeAdapter
				.setDropDownViewResource(R.layout.my_simple_dropdown_item_1);
		jobTypeSpinner.setAdapter(jobTypeAdapter);
		// ���ʽ��㷽ʽ
		String[] salaryType = { "Сʱ/Ԫ", "��/Ԫ", "��/Ԫ" };
		ArrayAdapter<String> salaryAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				salaryType);
		salaryTypeSpinner.setAdapter(salaryAdapter);

		/*
		 * ʡ���У������ؼ����˵�
		 */
		// ��ȡʡ��ֱϽ��
		String[] objects0 = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			objects0[i] = data[i][0][0];
		}
		// Ĭ����ʾ����
		ArrayAdapter<String> province = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				objects0);

		provinceSpinner.setAdapter(province);

		ArrayAdapter<String> city = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				new String[] { "������" });
		citySpinner.setAdapter(city);

		ArrayAdapter<String> countrySideAdapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.my_simple_dropdown_item_1,
				new String[] { "������", "������", "������", "������", "������", "������", "��̨��",
						"ʯ��ɽ��", "��ɽ��", "ͨ����", "˳����", "��ͷ����", "��ƽ��", "������",
						"������", "ƽ����", "����" });
		countySpinner.setAdapter(countrySideAdapter);

		provinceSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				ArrayAdapter<String> cityAdapter = null;

				ArrayList<String> city = new ArrayList<String>();// ��ȡʡ�������

				for (int j = 0; j < data[position].length; j++) {
					city.add(data[position][j][0]);

				}
				/*
				 * if(city.size()>0) city.remove(0);// ȥ����һ��ʡ��
				 */cityAdapter = new ArrayAdapter<String>(
						getApplicationContext(),
						R.layout.my_simple_dropdown_item_1, city);
				citySpinner.setAdapter(cityAdapter);
				positionPorvince = position;// ��¼ʡ�������е�λ��

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		// �����м�����
		citySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				ArrayAdapter<String> countyAdapter = null;
				cityPorvince = position;
				ArrayList<String> county = new ArrayList<String>();// ��ȡ���������
				for (int j2 = 0; j2 < data[positionPorvince][cityPorvince].length; j2++) {

					county.add(data[positionPorvince][cityPorvince][j2]);
				}
				/*
				 * if(county.size()>0) county.remove(0);//ɾ����һ��ʡ
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
		mLocationClient = new LocationClient(getApplicationContext()); // ����LocationClient��
		mLocationClient.registerLocationListener(myListener); // ע���������

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// ���ö�λģʽ
		option.setCoorType("bd09ll");// ���صĶ�λ����ǰٶȾ�γ��,Ĭ��ֵgcj02
		option.setScanSpan(5000);// ���÷���λ����ļ��ʱ��Ϊ5000ms
		option.setIsNeedAddress(true);// ���صĶ�λ���������ַ��Ϣ
		option.setNeedDeviceDirect(true);// ���صĶ�λ��������ֻ���ͷ�ķ���

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

	// ʡ���ز˵�������
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
					android.R.layout.simple_spinner_item, new String[] { "��" });
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
	 * ����λ�û�ȡ
	 */
	public void onImageViewClick(View view) {
		mLocationClient.start();
		addrEditText.setText(addr);
		mLocationClient.stop();
	}

	/*
	 * ����ѡ��
	 */
	public void onCalendarListener(View view){
		
	}
	// �۵��б�����������ʱδ�á�
	private class MyExpandableListAdapter extends BaseExpandableListAdapter {
		// Sample data set. children[i] contains the children (String[]) for
		// groups[i].
		private String[] groups = { "��ʷ��ְģ��" };
		private String[][] children = { { "����", "����", "�ҽ�", "��ķ" } };

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
