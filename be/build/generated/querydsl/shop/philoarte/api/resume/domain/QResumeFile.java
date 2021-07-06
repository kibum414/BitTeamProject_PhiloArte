package shop.philoarte.api.resume.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResumeFile is a Querydsl query type for ResumeFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResumeFile extends EntityPathBase<ResumeFile> {

    private static final long serialVersionUID = -842680714L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResumeFile resumeFile = new QResumeFile("resumeFile");

    public final StringPath fileDetail = createString("fileDetail");

    public final StringPath fileTitle = createString("fileTitle");

    public final StringPath fileWorkedDate = createString("fileWorkedDate");

    public final StringPath fname = createString("fname");

    public final BooleanPath repImg = createBoolean("repImg");

    public final QResume resume;

    public final NumberPath<Long> resumeFileId = createNumber("resumeFileId", Long.class);

    public final StringPath uuid = createString("uuid");

    public QResumeFile(String variable) {
        this(ResumeFile.class, forVariable(variable), INITS);
    }

    public QResumeFile(Path<? extends ResumeFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResumeFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResumeFile(PathMetadata metadata, PathInits inits) {
        this(ResumeFile.class, metadata, inits);
    }

    public QResumeFile(Class<? extends ResumeFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
    }

}

