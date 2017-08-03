package com.github.seijuro.common.scrap.publicdata.recall;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

@ToString
public class RecallExtra{
    @Getter(AccessLevel.PUBLIC)
    @SerializedName(RecallProperty.Content.Extra.TIME)
    private final String time;
    @Getter(AccessLevel.PUBLIC)
    @SerializedName(RecallProperty.Content.Extra.NEW)
    private final String _new;
    @Getter(AccessLevel.PUBLIC)
    @SerializedName(RecallProperty.Content.Extra.MACHINE)
    private final String machine;
    @Getter(AccessLevel.PUBLIC)
    @SerializedName(RecallProperty.Content.Extra.TIMESECOND)
    private final String timeSecond;
    @Getter(AccessLevel.PUBLIC)
    @SerializedName(RecallProperty.Content.Extra.INC)
    private final String inc;

    /**
     * C'tor
     * @param $time
     * @param $new
     * @param $machine
     * @param $timeSecond
     * @param $inc
     */
    public RecallExtra(String $time, String $new, String $machine, String $timeSecond, String $inc) {
        this.time = $time;
        this._new = $new;
        this.machine = $machine;
        this.timeSecond = $timeSecond;
        this.inc = $inc;
    }
}
