/*
 * Copyright 2011 ZerothAngel <zerothangel@tyrannyofheaven.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tyrannyofheaven.bukkit.zPermissions.model;

import org.tyrannyofheaven.bukkit.zPermissions.util.uuid.UuidUtils;

import java.util.Date;
import java.util.UUID;

/**
 * Represents group membership.
 * 
 * @author zerothangel
 */
public class Membership {

    private Long id;

    private String member;

    private String displayName;

    private PermissionEntity group;

    private Date expiration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PermissionEntity getGroup() {
        return group;
    }

    public void setGroup(PermissionEntity group) {
        this.group = group;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public UUID getUuid() {
        return UuidUtils.uncanonicalizeUuid(getMember());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Membership)) return false;
        Membership o = (Membership)obj;
        return getMember().equals(o.getMember()) &&
            getGroup().equals(o.getGroup());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + getMember().hashCode();
        result = 37 * result + getGroup().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Membership[%s -> %s/%s]", getGroup().getName(), getMember(), getDisplayName());
    }

}
