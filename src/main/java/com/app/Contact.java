package com.app;

public class Contact {
    private String name;
    private String email;
    private String phone;

    // Constructor for Builder Class
    private Contact(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
        }

    public void setPhone(String phone){
        this.phone = phone;
    }



    // Builder class for constructing Contact objects
    public static class Builder {
        private String name = "";
        private String email = "";
        private String phone = "";

        // Setter methods for name, email, and phone
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        // Build method to create a Contact object
        public Contact build() {
            return new Contact(this);
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Email: " + email + ", Phone: " + phone;
        }
    }
}
