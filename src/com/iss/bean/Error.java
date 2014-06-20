package com.iss.bean;

import java.util.List;

import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iss.R;
import com.iss.exception.NetRequestException;

public class Error extends BaseBean<Error> {

	public static final String COMERRORINFO="网络未知错误,请稍后";
	
	private String errorId;
	private String errorInfo;

	public Error() {
		super();
	}
	
	

	public Error(String errorInfo) {
		super();
		this.errorInfo = errorInfo;
	}



	public Error(String errorId, String errorInfo) {
		super();
		this.errorId = errorId;
		this.errorInfo = errorInfo;
	}

	public void print(Context context) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.userdefinedtoast, null);
		// TextView txtView_Title = (TextView)
		// view.findViewById(R.id.txt_Title);
		TextView txtView_Context = (TextView) view
				.findViewById(R.id.txt_context);
		// ImageView imageView = (ImageView)
		// view.findViewById(R.id.image_toast);
		txtView_Context.setText(errorInfo);
		Toast toast = new Toast(context);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(view);
		toast.show();
	}

	@Override
	public Error parseJSON(JSONObject jsonObj) {

		errorId = jsonObj.optString("errorId");
		errorInfo = jsonObj.optString("errorInfo");

		return this;
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error cursorToBean(Cursor cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentValues beanToValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Error> parseArrayJSON(JSONObject jsonObj) throws NetRequestException {
		// TODO Auto-generated method stub
		return null;
	}

}
