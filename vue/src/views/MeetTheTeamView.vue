<template>
  <div class="about-page">
    <!-- About the App section -->
    <section class="about-app">
      <div class="container">
        <h2>All About Book Worm Buddies</h2>
        <p>This application helps families track the amount of reading each family member does. As being an active reader is important to both parents and children, both Parents and children can track the books that are being read, as well as the number of minutes spent reading by each family member. Books can be entered by entering the data for the book, or by searching an online API based on the ISBN. Prizes can be awarded by reaching goals set by a parent. Parents can control the prizes and their children's reading goals.</p>
      </div>
    </section>

    <!-- Meet The Team section -->
    <section class="meet-the-team">
      <div class="container">
        <h2 class="section-title">Meet The Team</h2>
        <!-- Developer sections -->
        <div class="developer-section">
          <h3 class="developer-name">Dominique "Dom" Johnson</h3>
          <img src="src\assets\Images\Dom.jpg" alt="Developer Picture" class="developer-picture">
          <p>Dedicated professional with over a decade of successful experience as a Sales & F&I Manager in the automotive industry, bolstered by disciplined Air Force training. Proudly served my country in the US Air Force. Transitioning to a new career as a Junior Software Developer, specializing in Java, SQL, JavaScript, React, and CSS. Proven track record in cultivating customer relationships, streamlining processes, and ensuring regulatory compliance. Passionate about technology, with a love for legos and continual learning. Committed to being a collaborative team player and leveraging strong problem-solving skills to drive success in software development.</p>
          <div class="developer-links">
            <a href="https://www.linkedin.com/in/dominiquejohnsonww" class="linkedin-button">Connect With Me!</a>
            <a href="mailto:dom.jhnson@gmail.com" class="email-button">Contact Me!</a>
          </div>
        </div>

        <div class="developer-section">
          <h3 class="developer-name">Ronald "Ron" Roberts</h3>
          <img src="@/assets/Images/Ron.jpg" alt="Developer Picture" class="developer-picture">
          <p>I offer 10+ years of experience working directly with customers over the phone and in person, primarily in customer support. I have completed two certifications from Duke University. The first certification is in Programming Foundations with JavaScript, HTML and CSS, while the second certification is in Java Programming: Solving Problems with Software. Although I haven’t worked directly in IT, my customer support experience has helped me build skills in communication, persuasion, and problem-solving. Which I believe will translate well into assessing, identifying, and resolving customer specific solutions within an IT setting. I am also actively working to continue to build my portfolio and knowledge within IT and I am looking forward to networking with others within the IT profession.</p>
          <div class="developer-links">
            <a href="https://www.linkedin.com/in/ronald-roberts-418037152" class="linkedin-button">Connect With Me!</a>
            <a href="mailto:rbroberts0523@gmail.com" class="email-button">Contact Me!</a>
          </div>
        </div>

        <div class="developer-section">
          <h3 class="developer-name">Sonal Purwar</h3>
          <img src="@/assets/Images/Sonal.jpg" alt="Developer Picture" class="developer-picture">
          <p>From my early days in high school, I discovered a profound fascination with the world of coding. What began as a curious exploration soon evolved into a full-blown passion, as I immersed myself in the intricacies of programming languages and the limitless possibilities they offer. The thrill of turning lines of code into functional solutions ignited a fire within me that continues to burn brightly to this day. Driven by an insatiable curiosity and a passion for tackling challenges head-on, I thrive in environments that demand innovative problem-solving. With a diverse academic background encompassing Mathematics, Finance and Business Administration, I bring a unique perspective to every project I undertake. At the core of my professional ethos lies a fervent dedication to problem-solving. Whether it's unraveling complex mathematical equations, devising strategic business plans, or writing elegant lines of code, I find immense satisfaction in navigating obstacles and finding creative solutions. After taking a hiatus from the workforce to prioritize family responsibilities, I am now embarking on an exciting journey to reignite my career in the tech industry. Let's collaborate, share ideas, and embark on a journey of innovation and growth together in the dynamic world of software development.</p>
          <div class="developer-links">
            <a href="https://www.linkedin.com/in/sonalpurwar" class="linkedin-button">Connect With Me!</a>
          </div>
        </div>

        <div class="developer-section">
          <h3 class="developer-name">Jamesson Kolleno</h3>
          <img src="@/assets/Images/Jamesson.jpg" alt="Developer Picture" class="developer-picture">
          <p>Hello! My name is Jamesson. Thanks for taking the time to get to know a little about me. When I was an elementary school I used to get in trouble all the time for getting out of my seat and helping other students finish their work when I was done. As I got older that mindset carried with me into the work place. I find that helping my peers get tasks done is an extremely rewarding opportunity to not only help others but build a positive workplace. Even when I was in a captain position at a previous role which involved leading peers and making sure all of our objectives were met on time, I would constantly help my teammates with their individual tasks to not only help them but help the overall success of the job. The IT field has been a career I've always wanted to jump into and now I finally have had the chance. I want to know and learn as much as I can and thrive in the opportunities presented to me. Once again thank you for taking the time to read my little paragraph. Please don't hesitate to reach out with any questions or feel free to just connect with me!</p>
          <div class="developer-links">
            <a href="https://www.linkedin.com/in/jamessonkoleno" class="linkedin-button">Connect With Me!</a>
            <a href="mailto:jamessonkoleno@gmail.com" class="email-button">Contact Me!</a>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      developers: [
        { 
          id: 1, 
          name: 'Dominique "Dom" Johnson', 
        },
        { 
          id: 2, 
          name: 'Ronald "Ron" Roberts', 
        },
        { 
          id: 3, 
          name: 'Sonal Purwar', 
        },
        { 
          id: 4, 
          name: 'Jamesson Kolleno', 
        }
      ]
    }
  }
}
</script>

<style scoped>
.about-page {
  font-family: Arial, sans-serif;
}

.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.about-app {
  /* Gradient background */
  background: linear-gradient(to bottom right, #FFD166, #6A0572);
  color: white;
  padding: 50px 0;
  text-align: center;
}

.about-app h2 {
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
}

.meet-the-team {
  padding: 50px 0;
}

.section-title {
  text-align: center;
}

.developer-section {
  margin-bottom: 40px;
}

.developer-picture {
  width: 200px;
  height: 200px;
  background-color: #050505; /* Placeholder color */
  border-radius: 50%;
  margin: 0 auto 20px; /* Centering the image */
  display: block; /* Ensuring the image is a block element */
}
.developer-name {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 20px;
}

.developer-section p {
  font-size: 18px;
  line-height: 1.5;
  text-align: center;
}

.developer-links {
  margin-top: 20px;
  text-align: center; 
}

.linkedin-button,
.email-button {
  display: inline-block;
  padding: 10px 20px;
  margin-right: 10px;
  font-size: 16px;
  border-radius: 8px;
  text-decoration: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.linkedin-button {
  background-color: #3498DB;
  color: white;
}

.linkedin-button:hover {
  background-color: #da591e;
}

.email-button {
  background-color: #FF6F61;
  color: white;
}

.email-button:hover {
  background-color: #41d4d4;
}
</style>
