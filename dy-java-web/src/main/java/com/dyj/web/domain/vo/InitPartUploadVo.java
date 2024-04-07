package com.dyj.web.domain.vo;

public class InitPartUploadVo extends BaseVo{

    private String upload_id;

    public String getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(String upload_id) {
        this.upload_id = upload_id;
    }

    @Override
    public String toString() {
        return "InitPartUploadVo{" +
                "upload_id='" + upload_id + '\'' +
                ", description='" + description + '\'' +
                ", error_code=" + error_code +
                '}';
    }
}
