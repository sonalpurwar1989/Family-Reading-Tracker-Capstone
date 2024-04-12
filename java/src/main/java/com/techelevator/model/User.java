package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private int id;
   private String username;
   @JsonIgnore
   private String password;
   @JsonIgnore
   private boolean activated;
   private int minutesRead;
   private Set<Authority> authorities = new HashSet<>();
   private String userType;
   private String familyId;

   public String getUserType() {
      return userType;
   }

   public void setUserType(String userType) {
      this.userType = userType;
   }

   public void setFamilyId(String familyId) {
      this.familyId = familyId;
   }

   public void setEmailId(String emailId) {
      this.emailId = emailId;
   }

   public String getFamilyId() {
      return familyId;
   }

   public String getEmailId() {
      return emailId;
   }

   public User(int id, String username, String password, boolean activated, int minutesRead, Set<Authority> authorities, String userType, String familiyId, String emailId) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.activated = activated;
      this.minutesRead = minutesRead;
      this.authorities = authorities;
      this.userType = userType;
      this.familyId = familiyId;
      this.emailId = emailId;
   }

   private String emailId;

   public User() { }

   public int getMinutesRead() {
      return minutesRead;
   }

   public void setMinutesRead(int minutesRead) {
      this.minutesRead = minutesRead;
   }

   public User(int id, String username, String password, String authorities, int minutesRead) {
      this.id = id;
      this.username = username;
      this.password = password;
      if (authorities != null) this.setAuthorities(authorities);
      this.activated = true;
      this.minutesRead = minutesRead;


   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for (String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
