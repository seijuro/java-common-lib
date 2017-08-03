package com.github.seijuro.common.scrap.publicdata.recall;

import com.google.gson.annotations.SerializedName;

public class RecallExtra{
    @SerializedName(RecallProperty.Content.Extra.TIME)
    private final String time;
    @SerializedName(RecallProperty.Content.Extra.NEW)
    private final String _new;
    @SerializedName(RecallProperty.Content.Extra.MACHINE)
    private final String machine;
    @SerializedName(RecallProperty.Content.Extra.TIMESECOND)
    private final String timeSecond;
    @SerializedName(RecallProperty.Content.Extra.INC)
    private final String inc;

    public RecallExtra(String $time, String $new, String $machine, String $timeSecond, String $inc) {
        this.time = $time;
        this._new = $new;
        this.machine = $machine;
        this.timeSecond = $timeSecond;
        this.inc = $inc;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("extra(").append(RecallProperty.Content.FieldName.Extra).append(") = {");

        sb.append("time : [").append(this.time).append("], ")
                .append("new : [").append(this._new).append("], ")
                .append("machine : [").append(this.machine).append("], ")
                .append("time-second : [").append(this.timeSecond).append("], ")
                .append("inc : [").append(this.inc).append("]}");

        return sb.toString();
    }
}
