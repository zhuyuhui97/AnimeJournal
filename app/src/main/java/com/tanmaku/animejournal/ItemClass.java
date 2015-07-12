package com.tanmaku.animejournal;

import java.util.GregorianCalendar;

/**
 * Created by zhuyuhui on 2015/7/11.
 */
public class ItemClass {
    long animeNum;
    int episodeNum;
    GregorianCalendar date;

    ItemClass (long animeNum, int episodeNum, GregorianCalendar date){
        this.animeNum=animeNum;
        this.episodeNum=episodeNum;
        this.date=date;
    }
}