package shop.philoarte.api.artist.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtistFile is a Querydsl query type for ArtistFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArtistFile extends EntityPathBase<ArtistFile> {

    private static final long serialVersionUID = -2028931798L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtistFile artistFile = new QArtistFile("artistFile");

    public final QArtist artist;

    public final NumberPath<Long> artistFileId = createNumber("artistFileId", Long.class);

    public final StringPath imgName = createString("imgName");

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QArtistFile(String variable) {
        this(ArtistFile.class, forVariable(variable), INITS);
    }

    public QArtistFile(Path<? extends ArtistFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtistFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtistFile(PathMetadata metadata, PathInits inits) {
        this(ArtistFile.class, metadata, inits);
    }

    public QArtistFile(Class<? extends ArtistFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new QArtist(forProperty("artist")) : null;
    }

}

