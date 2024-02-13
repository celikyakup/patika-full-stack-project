
import './App.css'
import ClassInfo from './Component/Classes/ClassInfo'
import Calculator from './Component/Classes/calculator/Calculator'
import HeaderContent from './Component/Navigation/HeaderContent'
import InfoBox from './Component/Navigation/InfoBox'
import ColorSchemesExample from './Component/Navigation/Navbar'
import Contact from './Component/footer/contact/Contact'
import Trainers from './Component/midSection/trainers/trainers'

function App() {
 

  return (
    <>
    <section className='header'>
      <ColorSchemesExample />
      <HeaderContent />
     </section>
     <section className="section-first">
      <InfoBox />
      </section>
    <section className='section-second'>
      <ClassInfo />
    </section>
    <Calculator />
    <Trainers />
    <Contact />
    </>
  )
}

export default App
