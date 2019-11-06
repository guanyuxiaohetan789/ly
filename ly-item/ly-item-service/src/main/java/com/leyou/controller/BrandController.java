package com.leyou.controller;


import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("brand")
public class BrandController {
    @Autowired
    BrandService service;

    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPageAndSort(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                         @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                                                         @RequestParam(value = "sort", required = false) String sort,
                                                         @RequestParam(value = "desc", defaultValue = "false") boolean desc,
                                                         @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> result = service.queryBrandByPageAndSort(page, rows, sort, desc, key);
        if (result == null || result.getTotal() == 0) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(result);

    }
}
