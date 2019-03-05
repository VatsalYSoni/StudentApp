/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.demo.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public final class RegistrationRequest {

    private RegistrationRequest() {
        // This class is not publicly instantiable
    }

    public static class ServerRegistrationRequest {

        @Expose
        @SerializedName("firstName")
        private String firstName;

        @Expose
        @SerializedName("lastName")
        private String lastName;

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        public ServerRegistrationRequest(String first_name, String last_name, String email, String password) {
            this.firstName = first_name;
            this.lastName = last_name;
            this.email = email;
            this.password = password;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }

            ServerRegistrationRequest that = (ServerRegistrationRequest) object;

            if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) {
                return false;
            }

            if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) {
                return false;
            }

            if (email != null ? !email.equals(that.email) : that.email != null) {
                return false;
            }
            return password != null ? password.equals(that.password) : that.password == null;
        }

        @Override
        public int hashCode() {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
