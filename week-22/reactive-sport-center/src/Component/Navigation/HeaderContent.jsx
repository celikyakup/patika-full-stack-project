

function HeaderContent() {
  return (
    <div style={{ padding: "150px 20% 0" }}>
      <h4
        style={{
          display: "inline",
          backgroundColor: "#2a4374",
          padding: "4px 10px",
          color: "white",
        }}
      >
        POWERFULL
      </h4>
      <h2 style={{ color: "white", fontSize: "80px" }}>
        Group <br />
        Practice <br />
        With Trainer
      </h2>
      <p style={{ backgroundColor: "rgba(0,0,0,0.7)", color: "white",fontSize:"30px" }}>
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Vitae,
        tempora. Consequatur accusamus a similique eum laudantium distinctio qui
        magni recusandae.
      </p>
      <div style={{paddingBottom:"50px",paddingTop:"20px"}}>
        <button
            style={{
            marginLeft: "20px",
            backgroundColor: "#2a4374",
            color: "white",
            padding: "10px 20px",
            border: "none",
            fontSize: "20px",
            }}
        >
            Sign Up
        </button>
        <button
            style={{
            marginLeft: "80px",
            backgroundColor: "transparent",
            color: "white",
            border: "#fefefe 1px ridge",
            padding: "10px 25px",
            fontSize: "20px",
            }}
        >
            Details
        </button>
      </div>

    </div>
    
  );
}

export default HeaderContent;
