import Footer from "../footer/Footer";
import "./contact.css"

const Contact = () => {
  return (
    <>
    <section className="third">
      <h2 className="title">CONTACT US</h2>
      <div className="line"></div>
      <p className="margin-lr">
        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Culpa quia
        dignissimos, soluta quaerat quasi itaque.
      </p>
      <div className="con">
        <div className="contact">
          <div className="contact-info">
            <p>
              <span>Mobile Number</span>
              <br />
              <span>+135 773 321 4442</span>
            </p>
            <p>
              <span>Mobile Number</span>
              <br />
              <span>+135 773 321 4442</span>
            </p>
          </div>
          <div className="appointment">
            <h1>Make An Appointment</h1>
            <input type="text" placeholder="Your Name" className="input-bg input-size" />
            <input type="text" placeholder="Your Email" className="input-bg input-size" />
            <textarea name="comment" id="" cols="20" rows="10" className="input-bg"></textarea>
          </div>
        </div>
        <div className="map">
            <iframe src="https://www.openstreetmap.org/export/embed.html?bbox=-0.004017949104309083%2C51.47612752641776%2C0.00030577182769775396%2C51.478569861898606&layer=mapnik" width={"100%"} height={"100%"}></iframe>
        </div>
      </div>
    </section>
    <Footer />
    </>
  );
};

export default Contact;
