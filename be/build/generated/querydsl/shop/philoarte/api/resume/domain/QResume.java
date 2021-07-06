package shop.philoarte.api.resume.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResume is a Querydsl query type for Resume
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResume extends EntityPathBase<Resume> {

    private static final long serialVersionUID = -919549478L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResume resume = new QResume("resume");

    public final shop.philoarte.api.common.domain.QBaseEntity _super = new shop.philoarte.api.common.domain.QBaseEntity(this);

    public final shop.philoarte.api.artist.domain.QArtist artist;

    public final shop.philoarte.api.category.domain.QCategory category;

    public final StringPath detail = createString("detail");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final ListPath<ResumeFile, QResumeFile> resumeFiles = this.<ResumeFile, QResumeFile>createList("resumeFiles", ResumeFile.class, QResumeFile.class, PathInits.DIRECT2);

    public final NumberPath<Long> resumeId = createNumber("resumeId", Long.class);

    public final StringPath selfIntroduce = createString("selfIntroduce");

    public final StringPath title = createString("title");

    public QResume(String variable) {
        this(Resume.class, forVariable(variable), INITS);
    }

    public QResume(Path<? extends Resume> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResume(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResume(PathMetadata metadata, PathInits inits) {
        this(Resume.class, metadata, inits);
    }

    public QResume(Class<? extends Resume> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new shop.philoarte.api.artist.domain.QArtist(forProperty("artist")) : null;
        this.category = inits.isInitialized("category") ? new shop.philoarte.api.category.domain.QCategory(forProperty("category")) : null;
    }

}

