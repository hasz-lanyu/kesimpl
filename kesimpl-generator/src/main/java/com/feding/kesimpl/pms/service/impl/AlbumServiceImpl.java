package com.feding.kesimpl.pms.service.impl;

import com.feding.kesimpl.pms.model.Album;
import com.feding.kesimpl.pms.mapper.AlbumMapper;
import com.feding.kesimpl.pms.service.AlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相册表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {

}
