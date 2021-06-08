package shop.philoarte.api.artist.service.fileService;

import shop.philoarte.api.artist.domain.Artist;
import shop.philoarte.api.artist.domain.ArtistFile;
import shop.philoarte.api.artist.domain.dto.ArtistDTO;
import shop.philoarte.api.artist.domain.dto.ArtistFileDTO;
import shop.philoarte.api.artist.domain.pageDomainDTO.PageRequestDTO;
import shop.philoarte.api.artist.domain.pageDomainDTO.PageResultDTO;
import shop.philoarte.api.common.util.ModelMapperUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface ArtistFilerService {

    ArrayList<ArtistFileDTO> saveFile(List<MultipartFile> uploadFiles);

    void artistFileDelete(Long artistFileId);

    PageResultDTO<ArtistDTO, Artist> getPageFileList(PageRequestDTO requestDto);

    default ArtistFileDTO EntityToDtoArtistFile(ArtistFile artistFile) {

        ArtistFileDTO artistFileDto = ArtistFileDTO.builder().artistFileId(artistFile.getArtistFileId())
                .uuid(artistFile.getUuid()).imgName(artistFile.getImgName()).path(artistFile.getPath()).build();

        return artistFileDto;
    }

    default ArtistFile dtoToEntityArtistFile(ArtistFileDTO artistFileDto) {

        ArtistFile artistFile = ArtistFile.builder().artistFileId(artistFileDto.getArtistFileId())
                .uuid(artistFileDto.getUuid()).imgName(artistFileDto.getImgName()).path(artistFileDto.getPath())
                .build();

        return artistFile;
    }

    default ArtistFile dtoToEntity(ArtistDTO artistDto) {
        ArtistFile artistFile = ModelMapperUtils.getModelMapper().map(artistDto, ArtistFile.class);

        return artistFile;
    }

    default ArtistFileDTO entityToDto(ArtistFile artistFile) {
        ArtistFileDTO artistFileDto = ModelMapperUtils.getModelMapper().map(artistFile, ArtistFileDTO.class);

        return artistFileDto;
    }

    default ArtistFile dtoEntityFileToEntityFile(ArtistFileDTO artistFileDto) {
        ArtistFile entityFile = ArtistFile.builder().artistFileId(artistFileDto.getArtistFileId())
                .imgName(artistFileDto.getImgName()).uuid(artistFileDto.getUuid()).build();

        return entityFile;

    }

    default Artist dtoEntity(ArtistDTO artistDto) {
        Artist entity = Artist.builder().artistId(artistDto.getArtistId()).username(artistDto.getUsername())
                .password(artistDto.getPassword()).name(artistDto.getName()).email(artistDto.getEmail())
                .phoneNumber(artistDto.getPhoneNumber()).address(artistDto.getAddress()).school(artistDto.getSchool())
                .department(artistDto.getDepartment()).build();

        return entity;

    }

    default ArtistDTO entityDto(Artist artist) {
        ArtistDTO entityDto = ArtistDTO.builder().artistId(artist.getArtistId()).username(artist.getUsername())
                .password(artist.getPassword()).name(artist.getName()).email(artist.getEmail())
                .phoneNumber(artist.getPhoneNumber()).address(artist.getAddress()).school(artist.getSchool())
                .department(artist.getDepartment()).build();

        return entityDto;

    }

    default ArtistDTO entityDto2(Artist artist) {
        ArtistDTO entityDto = ArtistDTO.builder().artistId(artist.getArtistId()).username(artist.getUsername())
                .password(artist.getPassword()).name(artist.getName()).email(artist.getEmail())
                .phoneNumber(artist.getPhoneNumber()).address(artist.getAddress()).school(artist.getSchool())
                .department(artist.getDepartment()).build();

        return entityDto;

    }
}
