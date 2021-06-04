import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { ArtService } from 'webapp/art'
import { addFileList } from 'webapp/art/reducer/art.reducer'
import ArtFile from './ArtFile'

const ArtUpload = ({ fileParam = [] }) => {

  const dispatch = useDispatch()
  const fileList = useSelector(state => state.arts.fileList)
  const [uploadResult, setUploadResult] = useState(fileParam)

  console.log("upload", fileList)

  const uploadFile = async (e) => {
    e.preventDefault()

    console.dir(e.target.files)

    const formData = new FormData()
    const files = e.target.files

    for (let i = 0; i < files.length; i++) {
      formData.append("files", files[i])
    }

    ArtService.artUpload(formData)
      .then(res => {
        console.log("res: ", res)
        res.data.forEach(uploadFileInfo => {
          uploadResult.push(uploadFileInfo)

          dispatch(addFileList(uploadFileInfo))
        })
        console.log("uploadResult Before", uploadResult)
        setUploadResult(uploadResult.slice(0))
        console.log("uploadResult After", uploadResult)
      })

  }

  return (
    <>
      <div className="col-md-12 col-sm-12">
        <div className="form-group">
          <label htmlFor="message" className="dark-color">
            파일 첨부
          </label>
          <input
            type="file"
            name="files"
            accept="image/*"
            className="md-input style-02 input_white"
            id="files"
            multiple={true}
            data-error="작품 파일을 첨부해주세요."
            onChange={e => uploadFile(e)}
          />
          {fileList?.map(fileObj => {
            return (
              <ArtFile key={fileObj.uuid} {...fileObj} />
            )
          })}
        </div>
      </div>
    </>
  )
}

export default ArtUpload