package org.acme.getting.started;




public class Account extends MyEntity {
    private Long personId;
    private Long defaultAddressId;

    public Long getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(Long defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }
}
