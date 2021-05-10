import React from 'react'
import { Link } from 'react-router-dom'

const ParticipantList = ({ list, indexOfFirstPost }) => {

  return (
    <>
      <table>
        <tr>
          <th>번호</th>
          <th className="subject-th">제목</th>
          <th>신청자</th>
          <th>신청일</th>
        </tr>
        <tr>
          <td>1</td>
          <td className="subject-td">제목</td>
          <td>신청자</td>
          <td>2021-04-30</td>
        </tr>
        {
          list.map((participant) =>
            <tr key={participant.participantNo}>
              <td>{++indexOfFirstPost}</td>
              <td className="subject-td">캠페인 제목</td>
              <td>
                <Link to={`/participants/detail/${participant.participantNo}`}>
                  {participant.name}
                </Link>
              </td>
              <td>{participant.regdate}</td>
            </tr>
          )
        }
      </table>
    </>
  )
}

export default ParticipantList