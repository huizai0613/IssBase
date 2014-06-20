package com.iss.view.tablefixheaders;

import java.util.Stack;

import android.util.SparseArray;
import android.view.View;

/**
 * The Recycler facilitates reuse of views across layouts.
 * 
 * @author Brais Gab�n (InQBarna)
 */
public class Recycler {

//	private Stack<View>[] views;
	private SparseArray<Stack<View>> views;

	/**
	 * Constructor
	 * 
	 * @param size
	 *            The number of types of view to recycle.
	 */
	@SuppressWarnings("unchecked")
	public Recycler(int size) {
//		views = new Stack[size];
		views  = new SparseArray<Stack<View>>();
//		for (int i = 0; i < size; i++) {
//			views[i] = new Stack<View>();
//		}
		
		views.put((TableContant.TOP), new Stack<View>());
		views.put((TableContant.BOTTON), new Stack<View>());
		views.put((TableContant.LEFT), new Stack<View>());
		views.put((TableContant.RIGHT), new Stack<View>());
		views.put((TableContant.LEFT | TableContant.TOP), new Stack<View>());
		views.put((TableContant.RIGHT | TableContant.TOP), new Stack<View>());
		views.put((TableContant.LEFT | TableContant.BOTTON), new Stack<View>());
		views.put((TableContant.RIGHT | TableContant.BOTTON), new Stack<View>());
		views.put((TableContant.CONTENT), new Stack<View>());
	}

	/**
	 * Add a view to the Recycler. This view may be reused in the function
	 * {@link #getRecycledView(int)}
	 * 
	 * @param view
	 *            A view to add to the Recycler. It can no longer be used.
	 * @param type
	 *            the type of the view.
	 */
	public void addRecycledView(View view, int type) {
		views.get(type).push(view);
//		views[type].push(view);
	}

	/**
	 * Returns, if exists, a view of the type <code>typeView</code>.
	 * 
	 * @param typeView
	 *            the type of view that you want.
	 * @return a view of the type <code>typeView</code>. <code>null</code> if
	 *         not found.
	 */
	public View getRecycledView(int typeView) {
		try {
//			return views[typeView].pop();
			return views.get(typeView).pop();
		} catch (java.util.EmptyStackException e) {
			return null;

		}
	}
}
