package com.example.lenovo.mvp_cou.present;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.lenovo.mvp_cou.weight.TouchCallBack;

//张宝明
public class SimpleTouchHelperCallback extends ItemTouchHelper.Callback {
    private TouchCallBack callBack;
    private boolean mswipEnable = true;

    public SimpleTouchHelperCallback(TouchCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //允许上下拖拽
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许向左滑动
        int swipe = ItemTouchHelper.LEFT;
        //drag拖拽的方向
        //swipe 滑动的方向
        return makeMovementFlags(drag, swipe);
    }

    /*
    拖动item时回调，可以调用Adapter的notifyMoved方法来交换两个ViewHolder的位置
    最后返回true，表示被拖动的ViewHolder已经移动到了目的的位置
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        callBack.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /*
    onSwiped
    当用户左右滑动item时达到删除条件就会调用，一般为一半，条目继续滑动删除，否则弹回
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        callBack.onItemDelete(viewHolder.getAdapterPosition());
    }

    //支持长安拖拽默认是true
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();

    }

    //支持滑动删除，即可以调用到onSwiped()方法，默认是true
    @Override
    public boolean isItemViewSwipeEnabled() {

        return mswipEnable;
    }

    //设置是否支持上面滑动
    public void setSwipEnable(boolean enable){
        mswipEnable = enable;
    }
}
