package com.plexobject.yodlee.domain;

import java.util.List;

public class LoginForm {
    public static class ContainerInfo {
        private String containerName;
        private int assetType;

        public String getContainerName() {
            return containerName;
        }

        public void setContainerName(String containerName) {
            this.containerName = containerName;
        }

        public int getAssetType() {
            return assetType;
        }

        public void setAssetType(int assetType) {
            this.assetType = assetType;
        }

        @Override
        public String toString() {
            return "ContainerInfo [containerName=" + containerName
                    + ", assetType=" + assetType + "]";
        }

    }

    private List<FormField> componentList;

    public List<FormField> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<FormField> componentList) {
        this.componentList = componentList;
    }

    @Override
    public String toString() {
        return "LoginForm [componentList=" + componentList + "]";
    }

}
