package com.examly.springapp.dto;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationResponse<T> {
private List<T> content;
@JsonProperty("pageNumber")
private int pageNumber;
@JsonProperty("pageSize")
private int pageSize;
private long totalElements;
private int totalPages;
private Pageable pageable;

public PaginationResponse(List<T> content, int pageNumber, 
int pageSize){
this.content=content;
this.pageNumber=pageNumber;
this.pageSize=pageSize;
this.totalElements=content==null ? 0 :content.size(); 
this.totalPages=0;
this.pageable = new Pageable(pageNumber, pageSize);
}
public List<T> getContent(){
    return content;
}
public int getPageNumber(){
    return pageNumber;
}
public int getPageSize(){
    return pageSize;
}
public long getTotalElements(){
    return totalElements;
}
public int getTotalPages(){
    return totalPages;  
}
public Pageable getPageable(){
    return pageable;
}

public static class Pageable {
    private int pageNumber;
    private int pageSize;
    
    public Pageable(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
    
    public int getPageNumber() { return pageNumber; }
    public int getPageSize() { return pageSize; }
}

}
