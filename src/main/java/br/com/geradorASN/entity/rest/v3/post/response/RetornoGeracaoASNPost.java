package br.com.geradorASN.entity.rest.v3.post.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetornoGeracaoASNPost {

    @JsonProperty("Id")
    private long id;

    @JsonProperty("TransactionId")
    private String transactionId;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "RetornoGeracaoASNPost [id=" + id + ", transactionId=" + transactionId + "]";
    }
    
}
