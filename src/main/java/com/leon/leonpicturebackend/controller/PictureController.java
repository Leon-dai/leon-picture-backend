package com.leon.leonpicturebackend.controller;

import com.leon.leonpicturebackend.annotation.AuthCheck;
import com.leon.leonpicturebackend.common.BaseResponse;
import com.leon.leonpicturebackend.common.ResultUtils;
import com.leon.leonpicturebackend.constant.UserConstant;
import com.leon.leonpicturebackend.model.dto.picture.PictureUploadRequest;
import com.leon.leonpicturebackend.model.entity.User;
import com.leon.leonpicturebackend.model.vo.PictureVO;
import com.leon.leonpicturebackend.service.PictureService;
import com.leon.leonpicturebackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {
    @Resource
    private PictureService pictureService;

    @Resource
    private UserService userService;

    /**
     * 上传图片（可重新上传）
     */
    @PostMapping("/upload")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<PictureVO> uploadPicture(
            @RequestPart("file") MultipartFile multipartFile,
            PictureUploadRequest pictureUploadRequest,
            HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        PictureVO pictureVO = pictureService.uploadPicture(multipartFile, pictureUploadRequest, loginUser);
        return ResultUtils.success(pictureVO);
    }

}
