import "./calculator.css"

const Calculator = () => {
  return (
    <section className="third calculator-con">
        <div className="calculator-text">
            <h2 className="title">BMI Calculator</h2>
            <p className="calculator-info">
            The body mass index (BMI) is a measure that uses your height and weight to work out if your weight is healthy.
                The BMI calculation divides an weight in kilograms by their height in metres squared. For example, A BMI of 25 means 25kg/m2.
            </p>
            <input type="number" placeholder="Your Height" className="height" />
            <span>&nbsp; cm &nbsp;</span>
            <input type="number" placeholder="Your Weight" className="weight" />
            <span>&nbsp; kg &nbsp;</span>
        </div>
        <div className="calculator-img">
            <h4 className="text-center">Your BMI</h4>
            <img src="./necessary-documents/photos/bmi-index.jpg" alt="" />
        </div>
    </section>
  )
}

export default Calculator