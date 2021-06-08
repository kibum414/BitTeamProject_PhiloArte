package shop.philoarte.api.artist.service.artistTestService;

import shop.philoarte.api.artist.domain.Artist;
import shop.philoarte.api.artist.domain.dto.ArtistDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructService {
    MapStructService INSTANCE = Mappers.getMapper(MapStructService.class);

    Artist dtoToArtist(ArtistDTO artistDto);

    ArtistDTO entityToArtist(Artist artist);
}
