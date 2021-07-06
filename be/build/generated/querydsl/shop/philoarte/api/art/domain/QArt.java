package shop.philoarte.api.art.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArt is a Querydsl query type for Art
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArt extends EntityPathBase<Art> {

    private static final long serialVersionUID = 1403353768L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArt art = new QArt("art");

    public final shop.philoarte.api.common.domain.QBaseEntity _super = new shop.philoarte.api.common.domain.QBaseEntity(this);

    public final NumberPath<Long> artId = createNumber("artId", Long.class);

    public final shop.philoarte.api.artist.domain.QArtist artist;

    public final shop.philoarte.api.category.domain.QCategory category;

    public final StringPath description = createString("description");

    public final StringPath mainImg = createString("mainImg");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final shop.philoarte.api.resume.domain.QResume resume;

    public final StringPath title = createString("title");

    public QArt(String variable) {
        this(Art.class, forVariable(variable), INITS);
    }

    public QArt(Path<? extends Art> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArt(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArt(PathMetadata metadata, PathInits inits) {
        this(Art.class, metadata, inits);
    }

    public QArt(Class<? extends Art> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new shop.philoarte.api.artist.domain.QArtist(forProperty("artist")) : null;
        this.category = inits.isInitialized("category") ? new shop.philoarte.api.category.domain.QCategory(forProperty("category")) : null;
        this.resume = inits.isInitialized("resume") ? new shop.philoarte.api.resume.domain.QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

