package com.taocares.dispatch.vo;

import com.taocares.dispatch.entity.Leave;

import java.util.List;

/**
 * 请假记录Vo
 *
 * @author qinkai
 * @date 2018/10/30
 */
public class LeaveVo {
    private List<Leave> applyLeaveList;
    private List<Leave> reviewLeaveList;

    public List<Leave> getApplyLeaveList() {
        return applyLeaveList;
    }

    public void setApplyLeaveList(List<Leave> applyLeaveList) {
        this.applyLeaveList = applyLeaveList;
    }

    public List<Leave> getReviewLeaveList() {
        return reviewLeaveList;
    }

    public void setReviewLeaveList(List<Leave> reviewLeaveList) {
        this.reviewLeaveList = reviewLeaveList;
    }
}
