package com.baiyi.parttimejobs.fragment;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.activity.Jianzhixiangqing;
import com.baiyi.parttimejobs.activity.userhome_jianzhiListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class UserHomeFragment extends Fragment implements OnClickListener{
	
	private TextView jiaJiao;//家教
	
	private  TextView paiDan;//派单
	
	private  TextView fuWuYuan;//服务员
	
	private TextView liYI;//礼仪
	
	private  TextView daiLi;//代理
	
	private  TextView xiaoNei;//校内兼职
	
	private  TextView cuXiao;//促销
	
	private TextView all;
	
	private View newest1;
	private View newest2;
	private View newest3;
	
	private ImageView moreNew;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_user_home, null);
	initView(view);
	
		return view;
	}
	



	

private void initView(View view) {
		
	
		
		jiaJiao=(TextView) view.findViewById(R.id.userhome_jiajiao);
		
		paiDan=(TextView) view.findViewById(R.id.userhome_paidan);
		
		fuWuYuan=(TextView) view.findViewById(R.id.userhome_fuwuyuan);//服务员
		
		liYI=(TextView) view.findViewById(R.id.userhome_liyi);//礼仪
		
		daiLi=(TextView)view.findViewById(R.id.userhome_daili);//代理
		
		xiaoNei=(TextView) view.findViewById(R.id.userhome_xiaoneijianzhi);//校内兼职
		
		cuXiao=(TextView) view.findViewById(R.id.userhome_cuxiao);//促销
		
		all=(TextView)view.findViewById(R.id.userhome_allcategory);
		
	    newest1=(View)view.findViewById(R.id.userhome_newest_1);
		newest2=(View)view.findViewById(R.id.userhome_newest_2);
		newest3=(View)view.findViewById(R.id.userhome_newest_3);
		
		
		
		moreNew=(ImageView)view.findViewById(R.id.user_home_more_icon);
		
		newest1.setOnClickListener(this);
		newest2.setOnClickListener(this);
		newest3.setOnClickListener(this);
		moreNew.setOnClickListener(this);
		jiaJiao.setOnClickListener(this);
		paiDan.setOnClickListener(this);
		fuWuYuan.setOnClickListener(this);
		liYI.setOnClickListener(this);
		daiLi.setOnClickListener(this);
		xiaoNei.setOnClickListener(this);
		cuXiao.setOnClickListener(this);
		all.setOnClickListener(this);
		
		
	}







	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0==newest1||arg0==newest2||arg0==newest3){
			Intent intent=new Intent(getActivity(),Jianzhixiangqing.class);
			startActivity(intent);
		}
	
		
		Intent intent=new Intent(getActivity(),userhome_jianzhiListActivity.class);
		if(arg0==jiaJiao){
			intent.putExtra("title", "家教");
			startActivity(intent);
		}else if(arg0==paiDan){
			intent.putExtra("title", "派单");
			startActivity(intent);
		}else if(arg0==fuWuYuan){
			intent.putExtra("title", "服务员");
			startActivity(intent);
		}else if(arg0==liYI){
			intent.putExtra("title", "礼仪");
			startActivity(intent);
		}else if(arg0==daiLi){
			intent.putExtra("title", "代理");
			startActivity(intent);
		}else if(arg0==xiaoNei){
			intent.putExtra("title", "校内");
			startActivity(intent);
		}else if(arg0==cuXiao){
			intent.putExtra("title", "促销");
			startActivity(intent);
		}else if(arg0==all){
			intent.putExtra("title", "所有");
			startActivity(intent);
		}else if(arg0==moreNew){
			intent.putExtra("title", "最新兼职");
			startActivity(intent);
		}
		
		
	
		
		
			


}
}
