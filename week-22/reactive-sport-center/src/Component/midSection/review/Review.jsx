import "./review.css"

const Review = () => {
  return (
    <section className="section-first">
      <h2 className="title">REVIEW CLIENT</h2>
      <div className="line"></div>
      <p className="margin-lr">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque laborum
        commodi nam quasi odit! Ipsam?
      </p>
      <div className="review-con">
        <div className="review">
          <div className="review-top">
            <div className="review-img">
              <img src="necessary-documents/photos/client1.jpg" alt="" />
            </div>
            <div className="review-text">
              <p>
                <b>Diel Expert</b> <br />
                CFO
              </p>
            </div>
          </div>
          <div className="comment">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident minus cumque odit quam harum voluptatum!</p>
          </div>
        </div>

        <div className="review">
          <div className="review-top">
            <div className="review-img">
              <img src="necessary-documents/photos/client2.jpg" alt="" />
            </div>
            <div className="review-text">
              <p>
                <b>Diel Expert</b> <br />
                CFO
              </p>
            </div>
          </div>
          <div className="comment">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident minus cumque odit quam harum voluptatum!</p>
          </div>
        </div>

      </div>
    </section>
  );
};

export default Review;
