package shop.philoarte.api.artist.service;

import shop.philoarte.api.artist.domain.Artist;
import shop.philoarte.api.artist.domain.ArtistFile;
import shop.philoarte.api.artist.domain.dto.ArtistDTO;
import shop.philoarte.api.artist.domain.dto.ArtistFileDTO;
import shop.philoarte.api.artist.domain.pageDomainDTO.PageRequestDTO;
import shop.philoarte.api.artist.domain.pageDomainDTO.PageResultDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ArtistService {

    ArtistDTO signin(ArtistDTO artistDto);

    List<Artist> getAllData();

    List<Artist> findAll();

    Optional<Artist> findById(Long artistId);

    void deleteById(Long artistId);

    ArtistDTO updateById(ArtistDTO artistDto);

    ArtistDTO updateMypage(ArtistDTO artistDto);

    PageResultDTO<ArtistDTO, Artist> getPageList(PageRequestDTO requestDto);

    Long register(ArtistDTO artistDto);

    Map<String, String> signup(ArtistDTO artistDto);

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

    default Map<String, Object> dtoToEntity(ArtistDTO artistDto) {
        Map<String, Object> entityMap = new HashMap<>();
        Artist artist = Artist.builder().artistId(artistDto.getArtistId()).username(artistDto.getUsername())
                .password(artistDto.getPassword()).name(artistDto.getName()).email(artistDto.getEmail())
                .phoneNumber(artistDto.getPhoneNumber()).address(artistDto.getAddress()).school(artistDto.getSchool())
                .department(artistDto.getDepartment())

                .build();
        entityMap.put("artist", artist);

        List<ArtistFileDTO> fileDtoList = artistDto.getArtistFileDtoList();
        if (fileDtoList != null && fileDtoList.size() > 0) {
            List<ArtistFile> artistFileList = fileDtoList.stream().map(artistFileDto -> {
                ArtistFile artistFile = ArtistFile.builder().artistFileId(artistFileDto.getArtistFileId())
                        .path(artistFileDto.getPath()).imgName(artistFileDto.getImgName()).uuid(artistFileDto.getUuid())
                        .artist(artist).build();
                return artistFile;
            }).collect(Collectors.toList());
            entityMap.put("fileList", artistFileList);
        }
        return entityMap;
    }

    default ArtistDTO entityToDto(Artist artist, List<ArtistFile> artistFiles) {
        ArtistDTO artistDto = ArtistDTO.builder().artistId(artist.getArtistId()).username(artist.getUsername())
                .name(artist.getName()).email(artist.getEmail()).phoneNumber(artist.getPhoneNumber())
                .address(artist.getAddress()).school(artist.getSchool()).department(artist.getDepartment()).build();

        if (artistFiles != null && artistFiles.size() > 0) {
            System.out.println("size : " + artistFiles.size());
            List<ArtistFileDTO> artistFileDtoList = artistFiles.stream().map(artistFile -> {

                if (artistFile == null) {
                    return null;
                }
                return ArtistFileDTO.builder().artistFileId(artistFile.getArtistFileId())
                        .imgName(artistFile.getImgName()).path(artistFile.getPath()).uuid(artistFile.getUuid()).build();
            }).collect(Collectors.toList());
            artistDto.setArtistFileDtoList(artistDto.getArtistFileDtoList());
        }

        return artistDto;
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
}
