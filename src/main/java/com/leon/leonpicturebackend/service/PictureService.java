package com.leon.leonpicturebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leon.leonpicturebackend.model.dto.picture.PictureUploadRequest;
import com.leon.leonpicturebackend.model.entity.Picture;
import com.leon.leonpicturebackend.model.entity.User;
import com.leon.leonpicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

/**
* @author leon
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-07-19 16:43:58
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

}
