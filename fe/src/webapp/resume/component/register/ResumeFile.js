import React, { useState, useImperativeHandle } from 'react';
import { ResumeService, ResumeFileItem } from 'webapp/resume/index';
import { useDispatch, useSelector } from 'react-redux';
import { addFileList } from 'webapp/resume/reducer/resume.reducer';
import AWS from 'aws-sdk'

// const S3_BUCKET ='image.resume.upload';
// const REGION ='ap-northeast-2';


// AWS.config.update({
//     accessKeyId: 'AKIAQI2SZ6FTGJRNBEMZ',
//     secretAccessKey: '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'
// })

// const myBucket = new AWS.S3({
//     params: { Bucket: S3_BUCKET},
//     region: REGION,
// })

// const ResumeFile = () => {


//     const [progress , setProgress] = useState(0);
//     const [selectedFile, setSelectedFile] = useState(null);

//     const handleFileInput = (e) => {
//         setSelectedFile(e.target.files[0]);
//     }

//     const uploadFile = (file) => {

//         const params = {
//             ACL: 'public-read',
//             Body: file,
//             Bucket: S3_BUCKET,
//             Key: file.name
//         };

//         myBucket.putObject(params)
//             .on('httpUploadProgress', (evt) => {
//                 setProgress(Math.round((evt.loaded / evt.total) * 100))
//             })
//             .send((err) => {
//                 if (err) console.log(err)
//             })
//         }
        
//     return <div>
//         <div>Native SDK File Upload Progress is {progress}%</div>
//         <input type="file" onChange={handleFileInput}/>
//         <button onClick={() => uploadFile(selectedFile)}> Upload to S3</button>
//     </div>
// };

// export default ResumeFile;


const ResumeFile = ({ fileParam = [] }) => {
    const dispatch = useDispatch();
    const fileList = useSelector((state) => state.resumes.current.resumeFiles);

    const [uploadResult, setUploadResult] = useState(fileParam);

    const uploadFile = async (e) => {
        e.preventDefault();
        console.dir(e.target.files);
        const formData = new FormData();
        const files = e.target.files;
        for (let i = 0; i < files.length; i++) {
            formData.append('uploadFiles', files[i]);
        }
        console.log('formData: ' + JSON.stringify(formData));

        ResumeService.uploadFile(formData).then((res) => {
            console.log('res : ', res);
            res.data.forEach((uploadFileInfo) => {
                uploadResult.push(uploadFileInfo);
                dispatch(addFileList(uploadFileInfo));
            });
            console.log('uploadResult', uploadResult);
        });
    };
    return (
        <>
            <div className="container dark-color" style={{ marginBottom: '40px', color: '#24182e' }}>
                <div className="">
                    <label className="font-20px">첨부파일</label>
                    <input type="file" name="imageFile" onChange={(e) => uploadFile(e)} multiple={true} />
                    {fileList.map((fileObj) => {
                        return <ResumeFileItem key={fileObj.uuid} {...fileObj} />;
                    })}
                </div>
            </div>
        </>
    );
};

export default ResumeFile;