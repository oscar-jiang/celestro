import earthImage from "..//assets/earth-north-america.png";
import nightSky from "..//assets/night-sky.jpg";


export const LandingPage = () => {
  return (
    <div className={"relative w-full bg-white py-35"}>
      <h1 className={"text-7xl font-serif text-center"}>Explore Beyond</h1>

      <div className={"relative w-full flex justify-center mt-3"}>
        <img src={nightSky} alt={"Night Sky"} className={'w-[80%] mt-10 h-[300px] rounded-4xl relative animate-fadeIn-1200'} />

        <div className={'absolute max-w-[500px] -top-14 animate-fadeIn-yTransform-1200'}>
          <img
            src={earthImage}
            alt={"Earth"}
            style={{clipPath : 'inset(0% 0% 20.8% 0%)'}}
          />

          <button className={'absolute top-35 left-25 bg-white/30 backdrop-blur-xs rounded-xl w-[300px] h-[100px] font-Sans'}>
            Start Simulation
          </button>
        </div>
      </div>
    </div>
  );
}

export default LandingPage;
