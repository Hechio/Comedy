package com.stevehechio.quotes;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;


class ExpandAdapter extends BaseExpandableListAdapter {
    Context context;
    private HashMap<String, List<String>>childTitles;
    private List<String>headerTitles;


    public ExpandAdapter(Context context, HashMap<String, List<String>> childTitles, List<String>headerTitles) {
        this.context = context;
        this.childTitles = childTitles;
        this.headerTitles = headerTitles;
    }

    @Override
    public int getGroupCount() {
        return headerTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childTitles.get(headerTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childTitles.get(headerTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.about_title,null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.expandTitle);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;


    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String more = (String)getChild(groupPosition,childPosition);
        if (convertView==null){

            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.about_more,null);
        }
        TextView text = (TextView)convertView.findViewById(R.id.expandMore);
        text.setTypeface(null,Typeface.BOLD);
        text.setText(more);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

