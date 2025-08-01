package com.green.gallery_jwt_jpa.item;

import com.green.gallery_jwt_jpa.item.model.ItemGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<?> readAll(@RequestParam(name = "ids" ,required = false) ArrayList<Integer> ids) {
        log.info("ids: {}", ids);
        List<ItemGetRes> items = itemService.findAll(ids);
        return ResponseEntity.ok(items);
    }
}
