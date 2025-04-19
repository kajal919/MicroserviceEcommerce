package com.scaler.projectservicejan31capstone.Controller;

import com.scaler.projectservicejan31capstone.DTO.SearchRequestDTO;
import com.scaler.projectservicejan31capstone.Exceptions.ProductNotFoundException;
import com.scaler.projectservicejan31capstone.Services.SearchService;
import com.scaler.projectservicejan31capstone.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    SearchService searchService;
    SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDTO searchRequestDTO)  {
        return searchService.search(searchRequestDTO.getQuery(),
                             searchRequestDTO.getPageNumber(),
                             searchRequestDTO.getPageSize(),
                             searchRequestDTO.getSortParam());
    }

    @GetMapping("/search")
    public Page<Product> search(@RequestParam String query,
                                @RequestParam int pageNumber,
                                @RequestParam int pageSize,
                                String sortParam) {
        return searchService.search(query, pageNumber, pageSize, sortParam);

    }
}
