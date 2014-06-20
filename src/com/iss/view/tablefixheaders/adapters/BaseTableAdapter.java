package com.iss.view.tablefixheaders.adapters;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iss.R;
import com.iss.view.tablefixheaders.TableContant;
import com.iss.view.tablefixheaders.TableFixHeaders;

/**
 * Common base class of common implementation for an {@link TableAdapter} that
 * can be used in {@link TableFixHeaders}.
 * 
 */
public abstract class BaseTableAdapter<T> implements TableAdapter {

	// 表格的5个主要位置
	public static final int TOP = 1 << 0;
	public static final int BOTTON = 1 << 1;
	public static final int LEFT = 1 << 2;
	public static final int RIGHT = 1 << 3;
	public static final int CONTENT = 1 << 4;
	public static final int ViewTypeCount = 9;
	protected T data;

	public void setData(T data) {
		this.data = data;
	}

	private final DataSetObservable mDataSetObservable = new DataSetObservable();

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		mDataSetObservable.registerObserver(observer);
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		mDataSetObservable.unregisterObserver(observer);
	}

	/**
	 * Notifies the attached observers that the underlying data has been changed
	 * and any View reflecting the data set should refresh itself.
	 */
	public void notifyDataSetChanged() {
		mDataSetObservable.notifyChanged();
	}

	/**
	 * Notifies the attached observers that the underlying data is no longer
	 * valid or available. Once invoked this adapter is no longer valid and
	 * should not report further data set changes.
	 */
	public void notifyDataSetInvalidated() {
		mDataSetObservable.notifyInvalidated();
	}

	@Override
	public int getItemViewType(int row, int column) {
		if (row == -1 && column == -1)
			return TableContant.LEFT | TableContant.TOP;
		if (row == -1 && column == getColumnCount() - 1)
			return TableContant.RIGHT | TableContant.TOP;
		if (row == getRowCount() - 1 && column == -1)
			return TableContant.LEFT | TableContant.BOTTON;
		if (row == getRowCount() - 1 && column == getColumnCount() - 1)
			return TableContant.RIGHT | TableContant.BOTTON;
		if (row == -1)
			return TableContant.TOP;
		if (column == -1)
			return TableContant.LEFT;
		return TableContant.CONTENT;
	}
}
