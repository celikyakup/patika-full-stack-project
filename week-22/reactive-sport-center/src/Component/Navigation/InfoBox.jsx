
function InfoBox() {
  return (
    <div style={{
        display:"flex",
        justifyContent:"space-between",
        padding:"25px 0 20px"
    }}>
       <div className="con-item">
        <h2 className="title">325</h2>
        <p>Course</p>
        </div> 
        
        <div className="con-item">
        <h2 className="title">405</h2>
        <p>Work Out</p>
        </div> 

        <div className="con-item">
        <h2 className="title">305</h2>
        <p>Working Hour</p>
        </div> 

        <div className="con-item">
        <h2 className="title">705</h2>
        <p>Happy Client</p>
        </div> 
    </div>
  )
}

export default InfoBox