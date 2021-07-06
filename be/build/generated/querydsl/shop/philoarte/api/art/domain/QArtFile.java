package shop.philoarte.api.art.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtFile is a Querydsl query type for ArtFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArtFile extends EntityPathBase<ArtFile> {

    private static final long serialVersionUID = -1179037628L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtFile artFile = new QArtFile("artFile");

    public final shop.philoarte.api.common.domain.QBaseEntity _super = new shop.philoarte.api.common.domain.QBaseEntity(this);

    public final QArt art;

    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath originalFileName = createString("originalFileName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final BooleanPath repImg = createBoolean("repImg");

    public final StringPath savedFileName = createString("savedFileName");

    public final StringPath uuid = createString("uuid");

    public final StringPath workedDate = createString("workedDate");

    public QArtFile(String variable) {
        this(ArtFile.class, forVariable(variable), INITS);
    }

    public QArtFile(Path<? extends ArtFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtFile(PathMetadata metadata, PathInits inits) {
        this(ArtFile.class, metadata, inits);
    }

    public QArtFile(Class<? extends ArtFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.art = inits.isInitialized("art") ? new QArt(forProperty("art"), inits.get("art")) : null;
    }

}

