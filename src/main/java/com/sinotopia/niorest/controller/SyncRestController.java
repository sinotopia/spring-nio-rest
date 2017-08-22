package com.sinotopia.niorest.controller;

import java.util.List;

import com.sinotopia.niorest.dto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinotopia.niorest.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Synchronous data controller
 *
 * @author JINGA4X
 */
@RestController("SyncRestController")
@Api(value = "", description = "Synchronous data controller")
public class SyncRestController {

    @Autowired
    private DataService dataService;

    /**
     * Returns {@link List< Data >}
     */
    @RequestMapping(value = "/sync/data", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Gets data", notes = "Gets data synchronously")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public List<Data> getData() {
        return dataService.loadData();
    }

}
