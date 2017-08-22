package com.sinotopia.niorest.service;

import java.util.List;
import java.util.concurrent.Future;

import com.sinotopia.niorest.dto.Data;

import rx.Observable;

public interface DataService {

    /**
     * @return
     */
    List<Data> loadData();

    /**
     * @return
     */
    Observable<List<Data>> loadDataHystrix();

    /**
     * @return
     */
    Future<List<Data>> loadDataHystrixAsync();

    /**
     * @return
     */
    Observable<List<Data>> loadDataObservable();

}